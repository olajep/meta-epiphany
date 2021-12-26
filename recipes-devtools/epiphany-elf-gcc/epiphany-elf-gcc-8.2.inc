inherit exotic-gcc-common

# TODO: Actual version is 8.3

#PARALLEL_MAKE = ""

# Third digit in PV should be incremented after a minor release

PV = "8.2.0"

# BINV should be incremented to a revision after a minor gcc release

BINV = "8.2.0"

#COREGCCDIR = "${COREBASE}/meta/recipes-devtools/gcc"
COREGCCDIR = "${FILE_DIRNAME}/gcc-8.2"

FILESEXTRAPATHS =. "${FILE_DIRNAME}/epiphany-elf-gcc/8.2:${COREGCCDIR}:"


DEPENDS =+ "mpfr gmp libmpc zlib"
NATIVEDEPS = "mpfr-native gmp-native libmpc-native zlib-native flex-native"

LICENSE = "GPL-3.0-with-GCC-exception & GPLv3"

LIC_FILES_CHKSUM = "\
    file://COPYING;md5=59530bdf33659b29e73d4adb9f9f6552 \
    file://COPYING3;md5=d32239bcb673463ab874e80d47fae504 \
    file://COPYING3.LIB;md5=6a6a8e020838b23406c81b19c1d46df6 \
    file://COPYING.LIB;md5=2d5025d4aa3495befef8f17206a5b0a1 \
    file://COPYING.RUNTIME;md5=fe60d87048567d4fe8c8a0ed2448bcc8 \
"

EGCCBRANCH = "epiphany-gcc-8"
SRC_URI = " git://github.com/adapteva/epiphany-gcc.git;branch=${EGCCBRANCH};name=${EGCCBRANCH} "

# Patches for epiphany
SRC_URI += " \
    file://0001-simple-object.h-simple_object_copy_lto_debug_section.patch \
    file://0002-simple-object.h-simple_object_copy_lto_debug_section.patch \
"

# Patches from core
SRC_URI += "\
    file://0001-gcc-4.3.1-ARCH_FLAGS_FOR_TARGET.patch \
    file://0002-gcc-poison-system-directories.patch \
    file://0003-gcc-4.3.3-SYSROOT_CFLAGS_FOR_TARGET.patch \
    file://0004-64-bit-multilib-hack.patch \
    file://0005-optional-libstdc.patch \
    file://0006-gcc-disable-MASK_RELAX_PIC_CALLS-bit.patch \
    file://0007-COLLECT_GCC_OPTIONS.patch \
    file://0008-Use-the-defaults.h-in-B-instead-of-S-and-t-oe-in-B.patch \
    file://0009-fortran-cross-compile-hack.patch \
    file://0010-cpp-honor-sysroot.patch \
    file://0011-MIPS64-Default-to-N64-ABI.patch \
    file://0012-Define-GLIBC_DYNAMIC_LINKER-and-UCLIBC_DYNAMIC_LINKE.patch \
    file://0013-gcc-Fix-argument-list-too-long-error.patch \
    file://0014-Disable-sdt.patch \
    file://0015-libtool.patch \
    file://0016-gcc-armv4-pass-fix-v4bx-to-linker-to-support-EABI.patch \
    file://0017-Use-the-multilib-config-files-from-B-instead-of-usin.patch \
    file://0018-Avoid-using-libdir-from-.la-which-usually-points-to-.patch \
    file://0019-export-CPP.patch \
    file://0020-Disable-the-MULTILIB_OSDIRNAMES-and-other-multilib-o.patch \
    file://0021-Ensure-target-gcc-headers-can-be-included.patch \
    file://0022-gcc-4.8-won-t-build-with-disable-dependency-tracking.patch \
    file://0023-Don-t-search-host-directory-during-relink-if-inst_pr.patch \
    file://0024-Use-SYSTEMLIBS_DIR-replacement-instead-of-hardcoding.patch \
    file://0025-aarch64-Add-support-for-musl-ldso.patch \
    file://0026-libcc1-fix-libcc1-s-install-path-and-rpath.patch \
    file://0027-handle-sysroot-support-for-nativesdk-gcc.patch \
    file://0028-Search-target-sysroot-gcc-version-specific-dirs-with.patch \
    file://0029-Fix-various-_FOR_BUILD-and-related-variables.patch \
    file://0030-nios2-Define-MUSL_DYNAMIC_LINKER.patch \
    file://0031-Add-ssp_nonshared-to-link-commandline-for-musl-targe.patch \
    file://0032-libgcc-Add-knob-to-use-ldbl-128-on-ppc.patch \
    file://0033-Link-libgcc-using-LDFLAGS-not-just-SHLIB_LDFLAGS.patch \
    file://0034-libgcc_s-Use-alias-for-__cpu_indicator_init-instead-.patch \
    file://0035-sync-gcc-stddef.h-with-musl.patch \
    file://0036-fix-segmentation-fault-in-precompiled-header-generat.patch \
    file://0037-Fix-for-testsuite-failure.patch \
    file://0038-Re-introduce-spe-commandline-options.patch \
    file://0039-riscv-Disable-multilib-for-OE.patch \
    file://0040-powerpc-powerpc64-Add-support-for-musl-ldso.patch \
    file://0041-Add-a-recursion-limit-to-libiberty-s-demangling-code.patch \
    file://0042-PR-debug-86964.patch \
    file://0043-PR85434-Prevent-spilling-of-stack-protector-guard-s-.patch \
    file://CVE-2019-14250.patch \
    file://CVE-2019-15847_p1.patch \
    file://CVE-2019-15847_p2.patch \
    file://CVE-2019-15847_p3.patch \
"



SRCREV = "171933c50a4db3671b56272e4b034b0a06f2d6d4"

# Language Overrides
FORTRAN = ""
JAVA = ""

EXTRA_OECONF_BASE = "\
    --with-newlib \
"

EXTRA_OECONF_INITIAL = "\
    --with-newlib \
    --disable-libmudflap \
    --disable-libgomp \
    --disable-libssp \
    --disable-libquadmath \
    --disable-lto \
    --disable-plugin \
    --enable-decimal-float=no \
"

EXTRA_OECONF_PATHS = "\
    --with-libtool-sysroot=${STAGING_DIR_HOST} \
    --with-native-system-header-dir=${STAGING_DIR_TARGET}${target_includedir} \
    --with-gxx-include-dir=${STAGING_DIR_TARGET}${target_includedir}/c++/${BINV} \ 
    --with-sysroot=${STAGING_DIR_TARGET} \ 
    --with-build-sysroot=${STAGING_DIR_TARGET} \
"
