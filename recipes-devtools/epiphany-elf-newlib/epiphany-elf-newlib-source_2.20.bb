##################################################################
# Override variables with the remote target details

EXOTIC_TARGET_ARCH = "epiphany"
EXOTIC_TARGET_OS = "elf"
EXOTIC_TARGET_SYS = "epiphany-elf"

# update these as appropriate!
EXOTIC_TARGET_CFLAGS = "${TARGET_CFLAGS_GVARIABLE}"
EXOTIC_TARGET_CXXFLAGS = "${TARGET_CXXFLAGS_GVARIABLE}"
EXOTIC_TARGET_CPPFLAGS = "${TARGET_CPPFLAGS_GVARIABLE}"
EXOTIC_TARGET_LDFLAGS = "${TARGET_LDFLAGS_GVARIABLE}" 

inherit exotic-set-paths

require epiphany-elf-newlib-${PV}.inc

#
# Now the script
#

inherit exotic-newlib-source
