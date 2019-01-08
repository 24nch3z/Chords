package ru.s4nchez.chords.presentation.presenter

abstract class BasePresenter<T> {

    protected var viewState: T? = null

    open fun bindView(view: T) {
        if (view == null) {
            throw IllegalArgumentException("view не может быть null")
        }
        this.viewState = view
    }

    open fun removeView() {
        viewState = null
    }
}