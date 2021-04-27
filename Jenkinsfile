pipeline {
	agent any
	
	stages {
		stage ('Build Stage') {
			
			steps {
				withMaven(maven : 'maven_3_8_1' ){
					sh 'maven clean build'
				
				}
				
			}
		}
	
	}
	
	post{
		always{
			cleanWs()
		}
	}
}