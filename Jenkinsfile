node {
def mvnHome = tool name: 'MAVEN_HOME', type: 'maven'
def rtMaven = Artifactory.newMavenBuild()
def server = Artifactory.server 'Artifactory'
buildInfo = Artifactory.newBuildInfo()
buildInfo.env.capture = true
      
stage('Checkout') {
checkout([$class: 'GitSCM', 
branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false,
extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: '19ebf8fe-6f94-4af7-880e-69ac9254eab3',
url: 'https://github.com/MADDELAARUNA/Spring201.git']]])
}
    stage('--------- Artifactory configuration ----------------') {
  rtMaven.tool = 'MAVEN_HOME' // Tool name from Jenkins configuration
  rtMaven.deployer releaseRepo: 'libs-release-local', snapshotRepo: 'libs-snapshot-local', server: server
  rtMaven.resolver releaseRepo: 'libs-release', snapshotRepo: 'libs-snapshot', server: server
 
 } 
stage('Build') {
      // Run the maven build
rtMaven.run pom: 'pom.xml', goals: 'clean install', buildInfo: buildInfo
   }
       stage('---------- SonarQube Analysis --------------') {
  withSonarQubeEnv('Sonarqube') {
   bat(/"${mvnHome}\bin\mvn" -Dmaven.test.failure.ignore sonar:sonar/)
  }
 }
    
   }

