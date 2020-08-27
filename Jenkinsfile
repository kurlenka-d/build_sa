node('master') {
  def version = "jenikins"
  def name = "pluhin31/test_sa"
//  def dockerRegistry = "https://docker.io"
  def registryCredential = "dockerhub"
  def image

  stage ("Checkout") {
    checkout scm
  }

  stage ("Docker: Build") {
      image = docker.build(
              "${name}:${version}",
              //"-f ./Dockerfiles/i2_web.Dockerfile ./Dockerfiles"
      )
  }

  stage ("Docker: Push") {
        docker.withRegistry(dockerRegistry, registryCredential) {
          image.push "${version}"
          echo "Docker Image pushed: ${name}:${version}"
        }
  }
}
