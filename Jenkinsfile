pipeline {
    agent any
	tools{
		jdk 'Java JDK'
		}
		
    stages {
        stage('Build-clean') {
            steps {
                echo 'Building..'
                cleanWs()
            }
        }
        
        stage('build-clone') {
            steps {
                echo 'cloning stage..'
                git branch:'master'
                credentialsId:CRED
                url:'https://github.com/UdayKumarN/TestNg_project.git'
            }
        }
        
        stage('Test') {
            steps {
                echo 'Testing..'
                script{
                	bat 'mvn test '
            }
        }
        
    }
}


	post ("Post-Build Actions"){
		always{
			publishHTML(target: [allowMissing:true,alwaysLinkToLastBuild: false,escapeUnderscore: false,keepAll: true,reportDir: 'test-output/', reportFiles:'**/emailable-report.html',reportName:'HTML_Report_1',reportTitles: '']) 
		}
		success ("JOB SUCCESS"){
			echo "Success Job"
			emailext attachmentsPattern: ' ***test-output/*.html',body: 'Hi Team,\n\n Please find the attached test summary Results.\n\n Thanks,\n Automation Team.\n\nThis is an Auto generated mail',from: 'udaykumarnarsingoju@gmail.com', subject: 'Test results Success', to: 'udaykumarnarsingoju@gmail.com'
		}
		failure ("JOB FAILURE"){
			echo "Failure Job"
			emailext attachmentsPattern: ' ***TestResults/**/*.html',body: 'Hi Team,\n\n Please find the attached test summary Results.\n\n Thanks,\n Automation Team.\n\nThis is an Auto generated mail',from: 'udaykumarnarsingoju@gmail.com', subject: 'Test results Failed', to: 'udaykumarnarsingoju@gmail.com'
		}
		unstable ("JOB UNSTABLE"){
			echo "Unstable Job"
		}
		aborted("JOB ABORTED"){
			echo "Aborted Job"
		}
	}
}
		