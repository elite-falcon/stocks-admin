pipeline {
    agent {label "linux"}
    stages {
        stage('Analyzing PR') {
            when {
                branch 'PR-*'
            }
            steps {
                echo 'this only runs for the PRs'
            }
        }
    }
}
