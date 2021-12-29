FILESEXTRAPATHS =. "${COREBASE}/meta/recipes-devtools/binutils/binutils:"

inherit epiphany-cross-for-machine
require epiphany-binutils-2.36.inc
require recipes-devtools/binutils/binutils_2.36.bb

# TODO: The epiphany toolchain has a different libbfd.so and libopcodes.so
# Per target libraries seem to be separated by path so we could do dynamic but
# need to sort out the install paths which looks messy with 🇨🇦 cross builds.
DISABLE_SHARED = "--disable-shared"

EXTRA_OECONF += " \
    --enable-install-libbfd \
    --enable-install-libiberty \
    --with-system-zlib \
    ${DISABLE_SHARED} \
"

target_prefix="${prefix}/${TARGET_SYS}/include"

do_install () {
    autotools_do_install

    # These are generic and installed by the MACHINE binutils
    rm -rf ${D}${datadir}/info
    rm -rf ${D}${datadir}/locale
    rm -rf ${D}${includedir}
    rm -rf ${D}${libdir}

    bindir_rel=${@os.path.relpath('${bindir}', '${target_prefix}/bin')}

    # Fix the /usr/${TARGET_SYS}/bin/* links
    for l in ${D}${target_prefix}/bin/*; do
        rm -f $l
        ln -sf $bindir_rel/${TARGET_PREFIX}`basename $l` $l
    done

    install -d ${D}${includedir}
    mv ${D}${prefix}/${HOST_SYS}/${TARGET_SYS}/include ${D}${includedir}/${TARGET_SYS}
    install -d ${D}${libdir}
    mv ${D}${prefix}/${HOST_SYS}/${TARGET_SYS}/lib ${D}${libdir}/${TARGET_SYS}

    rm -rf ${D}${prefix}/${HOST_SYS}

    install -d ${D}${target_prefix}/include
    for f in ansidecl.h symcat.h; do
        cp ${D}${includedir}/${TARGET_SYS}/$f ${D}${target_prefix}/include
    done

    # bfd_stdint.h encodes the compiler name in the header
    sed -i ${D}${prefix}/include/${TARGET_SYS}/bfd_stdint.h -e "s,${TARGET_PREFIX},,"
}

USE_ALTERNATIVES_FOR = ""

FILES_${PN}-dev += "${target_prefix}/include"
FILES_${PN}-staticdev += "${libdir}/${TARGET_SYS}"
