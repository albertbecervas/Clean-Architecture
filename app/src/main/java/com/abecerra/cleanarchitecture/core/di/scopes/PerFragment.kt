package com.base.project.core.di.scopes

import javax.inject.Scope
import kotlin.annotation.AnnotationRetention.RUNTIME


@Scope
@Retention(RUNTIME)
annotation class PerFragment
