#!/usr/bin/env groovy
pipeline {
   agent any
   tools{
      def MAVEN_HOME
   }
   stages {
      stage('Preparation') { 
         steps{
            echo "preparation stage...."
         }
      }
      stage('Build') {
         steps{

            sh 'mvn clean test'

         }

      }
      stage('Results') {
         steps{
            echo "results stage..."
         }
      }
   }
}