BASEURI="git://github.com/olajep/epiphany-gcc.git;branch=epiphany-gcc-10.2.0;protocol=https"
SRCREV = "6760f82ba0e8bae0c44a007cc0666bfe76a3fcb7"

do_symlink_git () {
    rmdir ${TMPDIR}/work-shared/gcc-${PV}-${PR}/gcc-${PV}
    ln -s git ${TMPDIR}/work-shared/gcc-${PV}-${PR}/gcc-${PV}
}
addtask do_symlink_git after do_unpack before do_patch
