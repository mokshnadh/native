//Jenkinsfile (Scripted Pipeline)
node {
  def mvnHome
  stage('Preparation') { // for display purposes
    // Get some code from a GitHub repository
    git 'https://github.com/mokshnadh/cloud.git'
    // Get the Maven tool.
    // ** NOTE: This 'M3' Maven tool must be configured
    // **       in the global configuration.
    mvnHome = tool 'M3'  }
  stage('Eureka Server') {
    dir('CloudNative/eureka-server') {
      stage('Build - Eureka Server') {
        // Run the maven build
        if (isUnix()) {
          sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean package"
        } else {
          bat(/"${mvnHome}\bin\mvn" -Dmaven.test.failure.ignore clean package/) } }
      stage('Results - Eureka Server') {
        archiveArtifacts 'target/*.jar' }
      stage('Docker - Eureka Server') {
        docker.build("cloudnativejava/eureka-server")  }    }
  stage('Restaurant-Service') {
    dir('CloudNative/restaurant-service') {
      stage('Build - Restaurant-Service') {
        // Run the maven build
        if (isUnix()) {
          sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean package"
        } else {
          bat(/"${mvnHome}\bin\mvn" -Dmaven.test.failure.ignore clean package/) } }
      stage('Results - Restaurant-Service') {
        junit '**/target/surefire-reports/TEST-*.xml'
        archiveArtifacts 'target/*.jar' }
      stage('Docker - Restaurant-Service') {
        docker.build("cloudnativejava/restaurant-service")  } } } }



