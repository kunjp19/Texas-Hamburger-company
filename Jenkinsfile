node{

    stage("clean workspace"){
        deleteDir()
    }

    stage("git checkout"){
        checkout scn

        def GIT_COMMIT = sh(returnStdout: true, script: "git rev-perse HEAD").trim().take(7)
        DOCKER_IMAGE_VERSION = "${BUILD_NUMBER-${GIT_COMMIT}"
    }

    stage('Run container on server'){
        try{
            sh "docker-compose down"
            sh "docker system prune"
            sh "docker-compose up --build -d"
        }

        cache(e){
            error "Service update failed"
        }

    }
}