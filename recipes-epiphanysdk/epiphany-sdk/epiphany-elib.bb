inherit epiphany-library autotools

DESCRIPTION = "Epiphany target library"
HOMEPAGE = "http://www.adapteva.com/"
LICENSE = "GPLv3"

LIC_FILES_CHKSUM = "file://../COPYING;md5=d32239bcb673463ab874e80d47fae504"

# 2019.1
BRANCH = "2019.1"
SRCREV = "0710d8afbd352c9c1dac7cb1617346f738561c86"
SRC_URI = " git://github.com/adapteva/epiphany-libs.git;branch=${BRANCH}"

ALLOW_EMPTY_${PN} = "1"

S = "${WORKDIR}/git/e-lib"

do_configure_prepend () {
    pushd ${S}
    ./bootstrap
    popd
}
