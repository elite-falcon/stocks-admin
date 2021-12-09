pipeline {
    agent {label "linux"}
    stages {
        stage('Hello') {
            steps {
                echo "hello from Jenkinsfile"
            }
        }
        stage('for the PR') {
            when {
                branch 'PR-*'
            }
            steps {
                echo 'this only runs for the PRs'
            }
        }
    }
}
