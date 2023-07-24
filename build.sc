import coursierapi.MavenRepository


interp.repositories.update(
  interp.repositories() ++ Seq(MavenRepository.of(
  "https://jitpack.io"
)))

@

import $ivy.`com.ivmoreau.githubmillscala::mill-github::9dcd1b8a48`

import mill._
import scalalib._
import mill.scalalib.publish._

import com.ivmoreau.millgithub.GitHubPublishModule
import com.ivmoreau.millgithub.ProjectRepository

object ex extends ScalaModule with GitHubPublishModule {
  override def scalaVersion = "3.2.2"

  override def publishRepository: ProjectRepository = ProjectRepository("ivanmoreau", "examplemillgithub")

  override def pomSettings: T[PomSettings] = PomSettings(
    organization = "com.ivmoreau",
    description = "Example of mill-github",
    url = "https://github.com/ivanmoreau/examplemillgithub",
    licenses = Seq(
      License.`MPL-2.0`
    ),
    versionControl = VersionControl.github("ivanmoreau","examplemillgithub"),
    developers = Seq(
      Developer(
        "ivanmoreau",
        "Ivan Molina Rebolledo",
        url = "ivmoreau.com"
      )))

  override def publishVersion: T[String] = "0.0.1"
}
