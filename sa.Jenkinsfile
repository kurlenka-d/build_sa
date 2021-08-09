node('master') {
  def version = "test"
  def name = "curl"
  def dockerRegistry = "jfrog.it-academy.by/public"
  def registryCredential = "jfrog-it"
  def image

  stage ("Checkout") {
    checkout scm
  }

  stage ("Docker: Build") {
      image = docker.build(
              "${dockerRegistry}/${name}:${version}",
              "--network=host .",
      )
  }

  stage ("Docker: Push") {
        docker.withRegistry('https://${dockerRegistry}', registryCredential) {
          image.push "${version}"
          echo "Docker Image pushed: ${dockerRegistry}/${name}:${version}"
        }
  }
}
