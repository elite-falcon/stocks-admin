pipeline {
    agent {label "linux"}
    stages {
        stage('Start') {
            steps {
                echo "Starting pipeline checks"
            }
        }
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
