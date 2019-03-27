node {
def mvnHome = tool name: 'MAVEN_HOME', type: 'maven'
      
stage('Checkout') {
checkout([$class: 'GitSCM', 
branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false,
extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: '19ebf8fe-6f94-4af7-880e-69ac9254eab3',
url: 'https://github.com/MADDELAARUNA/Spring201.git']]])
}
stage('Build') {
      // Run the maven build
         bat(/"${mvnHome}\bin\mvn" -Dmaven.test.failure.ignore clean package/)
   }
       stage('---------- SonarQube Analysis --------------') {
  withSonarQubeEnv('Sonarqube') {
   sh "${mvnHome}/bin/mvn -f sonar:sonar"
  }
 }
   }

