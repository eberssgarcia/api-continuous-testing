import sharedlib.testing.MavenFuncionalTest

def recipients = 'garciaayzanaeber@gmail.com'
def scenarios = ''
def type = ''

def utilsTesting = new MavenFuncionalTest(this)

try {
    node {
        stage("Preparation") {
            echo "Preparing the environment"
        }
        stage("Build") {
            echo "Building the project"
            utilsTesting.buildMaven()
        }
        stage("Test") {
            echo "Running the tests"
            utilsTesting.executeFunctionalTests(scenarios, type)
        }
        stage("Post Execution") {
            echo "Sending the report"
            utilsTesting.executePostExecutionTasks()
            utilsTesting.notifyByMail("SUCCESS", recipients)
        }
    }
} catch (Exception e) {
    node {
        utilsTesting.executeOnErrorExecutionTasks()
        utilsTesting.notifyByMail("FAILURE", recipients)
        throw e
    }
}