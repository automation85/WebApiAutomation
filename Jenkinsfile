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