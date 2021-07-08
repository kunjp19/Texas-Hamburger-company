node{

    stage("clean workspace"){
        deleteDir()
    }

    stage("git checkout"){
        checkout scn

        def GIT_COMMIT = sh(returnStdout: true, script: "git rev-parse HEAD").trim().take(7)
    }

    stage('Run container on server'){
        try{
            sh "docker-compose down"
            sh "docker system prune"
            sh "docker-compose up --build"
        }

        cache(e){
            error "Service update failed"
        }

    }
}