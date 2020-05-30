package com.bookapp.model

import com.domain.INT_NEGATIVE
import es.babel.easymvvm.core.constants.INT_ZERO

/**
 * Model to handle activity result feature
 *
 * <p>
 * Copyright (c) 2019, Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:jorge.valino@babel.es”>Jorge Valiño</a>
 */
data class ActivityResultHandlerModel(
        val id: Int,
        val implementation: ((Int, Result, Any?) -> Boolean) //RETURN TRUE IF IT IS REMOVE AFTER CONSUMED
) {
    sealed class Result(val code: Int) {

        object Success : Result(INT_NEGATIVE)

        object Fail : Result(INT_ZERO)

        class Other(code: Int) : Result(code)
    }
}