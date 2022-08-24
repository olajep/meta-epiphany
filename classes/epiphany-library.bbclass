inherit epiphany-target
inherit prepend-target-prefix-to-pn

PACKAGE_ARCH = "${TARGET_ARCH}"

MULTIMACH_TARGET_SYS = "${PACKAGE_ARCH}${TARGET_VENDOR}-${TARGET_OS}"

host_prefix := "${prefix}"
host_exec_prefix := "${exec_prefix}"

sysroot="${host_prefix}/${TARGET_SYS}/sys-root"
export prefix = "${sysroot}"

# TODO: Shouldn't need the -isystem?
TOOLCHAIN_OPTIONS = " -isystem ${STAGING_DIR_HOST}${includedir} --sysroot=${STAGING_DIR_HOST}${sysroot}"
#TOOLCHAIN_OPTIONS = " --sysroot=${STAGING_DIR_HOST}${sysroot}"
LDFLAGS_append = " --sysroot=${STAGING_DIR_HOST}${sysroot}"

SYSROOT_DIRS_append = " ${host_exec_prefix}/${TARGET_SYS}"

BASE_DEFAULT_DEPS_append= " ${TARGET_ARCH}-libgloss virtual/${TARGET_PREFIX}compilerlibs ${TARGET_ARCH}-libgcc"
