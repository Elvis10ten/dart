package com.fluentbuild.apollo.runner.client

class ClientFinalizer(
    private val artifactsCopier: ArtifactsCopier
) {

    private val lock = Object()
    private var hasFinalized = false

    fun finalize() {
        synchronized(lock) {
            if(hasFinalized) {
                return
            } else {
                hasFinalized  = true
            }
        }

        artifactsCopier.copy()
    }
}