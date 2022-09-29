node('master') {
  def version = "test"
  def name = "test_script2"
  def dockerRegistry = "jfrog.it-academy.by/public"
  def registryCredential = "jfrog_sa"
  def image

  stage ("Checkout") {
    checkout scm
  }

  stage ("Docker: Build") {
      image = docker.build(
              "${dockerRegistry}/${name}:${version}",
              ".",
      )
  }

  stage ("Docker: Push") {
        docker.withRegistry("https://${dockerRegistry}", registryCredential) {
          image.push "${version}"
          echo "Docker Image pushed: ${dockerRegistry}/${name}:${version}"
        }
  }
}
