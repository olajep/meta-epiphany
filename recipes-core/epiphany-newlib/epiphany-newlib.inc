require recipes-core/newlib/newlib.inc

BRANCH = "epiphany-newlib-snapshot-20211231"
SRC_URI = "git://github.com/olajep/epiphany-newlib.git;branch=${BRANCH};protocol=https"
SRCREV = "0ef40c0a0d6961710dfc6ad003eebcfafdaba17d"

S = "${WORKDIR}/git"

