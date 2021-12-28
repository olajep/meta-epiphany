FILESEXTRAPATHS =. "${COREBASE}/meta/recipes-devtools/gcc:"

DISABLE_STATIC=""

inherit epiphany-library
require recipes-devtools/gcc/gcc-${PV}.inc
require recipes-devtools/gcc/gcc-runtime.inc
require epiphany-gcc-shared-source.inc

SLIB = "${S}"

DEPENDS += "${TARGET_SYS}-${EPIPHANY_LIBC}"
PROVIDES := "virtual/${TARGET_PREFIX}compilerlibs"

libdir_append = "/${TARGET_SYS}"
datadir = "${prefix}/${TARGET_SYS}/share"
includedir = "${exec_prefix}/${TARGET_SYS}/include"

TOOLCHAIN_OPTIONS = " -isystem ${STAGING_DIR_HOST}${includedir}"

EXTRA_OECONF_PATHS_append = " \
    --libdir=${libdir} \
    --datarootdir=${datadir} \
    --includedir=${includedir} \
"

# TODO: Move to include or bbclass?
# Append prefix to package names to avoid collisions with the default target
python () {
    target_arch = d.getVar("TARGET_ARCH")
    orig_packages = (d.getVar("PACKAGES") or "").split()
    new_packages = []
    for orig_name in orig_packages:
        if target_arch in orig_name:
            new_name = orig_name
        else:
            new_name = target_arch + "-" + orig_name
        new_packages.append(new_name)
        files = d.getVar("FILES_" + orig_name) or ""
        d.delVar("FILES_" + orig_name)
        d.setVar("FILES_" + new_name, files)
    d.setVar("PACKAGES", " ".join(new_packages))
}
