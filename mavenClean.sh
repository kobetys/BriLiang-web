#!/bin/sh

mvn eclipse:clean clean -f vips-common-component/pom.xml
mvn eclipse:clean clean -f vips-mobile/vips-mobile-parent/pom.xml -e
