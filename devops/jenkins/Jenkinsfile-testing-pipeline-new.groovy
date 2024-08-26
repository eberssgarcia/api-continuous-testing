def recipients = 'garciaayzanaeber@gmail.com'
def scenarios = ''
def type = ''

try {
    node {
        stage("Preparation") {
            echo "Preparing the environment"
            // Aquí puedes agregar cualquier tarea de preparación, como clonar el repositorio
        }
        stage("Build") {
            echo "Building the project"
            // Sustituye utilsTesting.buildMaven() por los comandos de Maven directamente
            sh 'mvn clean install'
        }
        stage("Test") {
            echo "Running the tests"
            // Sustituye utilsTesting.executeFunctionalTests(scenarios, type) por los comandos para ejecutar las pruebas
//            sh "mvn clean test -Dscenarios=${scenarios} -Dtype=${type}"
            sh "mvn clean test \"-Dkarate.options=--tags @${scenarios}\""
        }
        stage("Post Execution") {
            echo "Sending the report"
            // Sustituye utilsTesting.executePostExecutionTasks() por cualquier tarea post-ejecución que necesites
            // Puedes usar comandos shell o cualquier otro script Groovy aquí
            // Envío de correo electrónico
            mail to: recipients,
                    subject: "Build SUCCESS",
                    body: "The build and tests were successful."
        }
    }
} catch (Exception e) {
    node {
        // Sustituye utilsTesting.executeOnErrorExecutionTasks() por cualquier tarea a ejecutar en caso de error
        echo "Handling error..."
        // Envío de correo en caso de fallo
        mail to: recipients,
                subject: "Build FAILURE",
                body: "The build or tests failed. Please check Jenkins for details."
        throw e
    }
}
