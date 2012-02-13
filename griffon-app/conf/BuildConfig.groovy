griffon.project.dependency.resolution = {
    inherits("global")
    log "warn"
    repositories {
        griffonHome()
        // pluginDirPath is only available when installed
        String basePath = pluginDirPath? "${pluginDirPath}/" : ''
        flatDir name: "swingxtrasBuilderPluginLib", dirs: ["${basePath}lib"]
        mavenCentral()
        mavenRepo 'http://repository.codehaus.org'
        mavenRepo 'http://repository.sonatype.org/content/groups/public'
    }
    dependencies {
        compile('org.codehaus.griffon:swingxtrasbuilder:0.4') {
            excludes 'groovy-all'
        }
        compile 'org.swinglabs:xswingx:0.2',
                'net.java.balloontip:balloontip:20090102',
                'com.l2fprod.common:l2fprod-common-all:6.9.1'
    }
}

griffon {
    doc {
        logo = '<a href="http://griffon.codehaus.org" target="_blank"><img alt="The Griffon Framework" src="../img/griffon.png" border="0"/></a>'
        sponsorLogo = "<br/>"
        footer = "<br/><br/>Made with Griffon (@griffon.version@)"
    }
}

log4j = {
    // Example of changing the log pattern for the default console
    // appender:
    appenders {
        console name: 'stdout', layout: pattern(conversionPattern: '%d [%t] %-5p %c - %m%n')
    }

    error 'org.codehaus.griffon',
          'org.springframework',
          'org.apache.karaf',
          'groovyx.net'
    warn  'griffon'
}
