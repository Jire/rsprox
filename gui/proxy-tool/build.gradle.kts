dependencies {
    implementation(projects.gui)
    implementation(libs.flatlaf)
    implementation(libs.mig.layout)
    implementation(projects.proxy)
    implementation(libs.inline.logger)
    implementation(platform(rootProject.libs.netty.bom))
    implementation(rootProject.libs.netty.buffer)
}
