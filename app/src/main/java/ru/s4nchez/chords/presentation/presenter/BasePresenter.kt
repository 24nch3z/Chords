package ru.s4nchez.chords.presentation.presenter

import io.reactivex.disposables.CompositeDisposable

abstract class BasePresenter<T> {

    protected var viewState: T? = null
    protected var disposable = CompositeDisposable()

    open fun bindView(view: T) {
        if (view == null) {
            throw IllegalArgumentException("view не может быть null")
        }
        this.viewState = view
    }

    open fun removeView() {
        viewState = null
        disposable.clear()
    }
}