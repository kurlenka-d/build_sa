node {
  def version = "jenikins"
  def name = "pluhin31/test_sa"
  def dockerRegistry = "docker.io"
  def registryCredential = "dockerhub"
  def image

  stage ("Checkout") {
    checkout scm
  }

  stage ("Docker: Build") {
    docker.withRegistry(dockerRegistry, registryCredential) {
      image = docker.build(
              "${dockerRegistry}/${name}:${version}",
              "."
              //"-f ./Dockerfiles/i2_web.Dockerfile ./Dockerfiles"
      )
    }
  }

  stage ("Docker: Push") {
    image.push "${version}"
    echo "Docker Image pushed: ${dockerRegistry}/${name}:${version}"
  }
}
