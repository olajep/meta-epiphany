##################################################################
# Override variables with the remote target details

EXOTIC_TARGET_ARCH = "epiphany"
EXOTIC_TARGET_OS = "elf"
EXOTIC_TARGET_SYS = "epiphany-elf"

# update these as appropriate!
EXOTIC_TARGET_CFLAGS = "${TARGET_CFLAGS_GVARIABLE}"
EXOTIC_TARGET_CXXFLAGS = "${TARGET_CXXFLAGS_GVARIABLE}"
EXOTIC_TARGET_CPPFLAGS = "${TARGET_CPPFLAGS_GVARIABLE}"
EXOTIC_TARGET_LDFLAGS = "-Wl,-O1 -Wl, -Wl,--as-needed" 

inherit exotic-set-paths-host-is-exotic-target

#
# Now all the scripts in this recipe can use TARGET_??
# or HOST_?? 
# or can use the original settings of TARGET_??_GVARIABLE and HOST_??_GVARIABLE
#

require epiphany-elf-gcc-${PV}.inc

##################################################################
# Part two of this refactoring will make this file an append to
# the exotic-libgcc_4.8.bb file and the following will be
# the content of that file!
# Consider making it clear that this is gcc with newlib!
##################################################################

#
# Now the script
#

require epiphany-elf-libgcc.inc

#
# Now update DEPENDS to ensure that the correct libraries get built
#

DEPENDS += " ${EXOTIC_TARGET_PREFIX}newlib "
