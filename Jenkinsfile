#!/usr/bin/env groovy
pipeline {
   agent any
   tools{
      maven 'Maven 3.6.3'
   }
   stages {
      stage('Preparation') { 
         steps{
            echo "preparation stage...."
			echo "M2_HOME = ${M2_HOME}"
         }
      }
      stage('Build') {
         steps{

            bat 'mvn -Dmaven.test.failure.ignore=true install'

         }

      }
      stage('Results') {
         steps{
            echo "results stage..."
         }
      }
   }
}