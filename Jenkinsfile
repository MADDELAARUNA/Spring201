node {
      tools {maven 'Maven_3.5.2'}
def mvnHome = tool name: 'MAVEN_HOME', type: 'maven' {maven 'Maven_3.5.2'}
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
   }

