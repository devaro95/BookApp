package com.bookapp.model

/**
 * Model to handle back feature
 *
 * <p>
 * Copyright (c) 2019, Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:jorge.valino@babel.es”>Jorge Valiño</a>
 */
data class BackModel(
        val disabled: Boolean = false,
        val implementation: (() -> Unit)? = null
)