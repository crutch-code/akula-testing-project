import React, {Component} from 'react'
import {News} from '../components/News'

export default class Main extends Component<any, any> {

    render() {
        return (
            <main>
                <div className={'section'}>
                    <div className="container">
                        <div className="row mb-5">
                            {Array.from({length: 15}).map(() =>
                                <News newsId={3} title='Akulaplay - магазин с душой.'
                                      image='https://media.cntraveller.com/photos/611bf0b8f6bd8f17556db5e4/master/pass/gettyimages-1146431497.jpg'
                                      authorId={1}
                                      authorName='Иванов И.'
                                      authorAvatar='https://www.vhv.rs/dpng/d/551-5511364_circle-profile-man-hd-png-download.png'
                                      date='15 октября 2023'>
                                    Мы - команда, которая профессионально улучшает Ваше впечатление от собственного
                                    авто!
                                    Более 5 лет мы помогаем нашим клиентам сделать правильный выборр и подбираем для их
                                    авто
                                    автомагнитолы на андроид, акустические системы и автоэлектронику.
                                    Наши клиенты часто говорят "Ваа-у!" после преображения их авто! В 100% случаев
                                    изменения
                                    заключаются в правильном подборе устройств, переходников и корректной установке.
                                    Скажи "Ваа-у!" почувствовав новые грани своего авто!
                                    Напиши по ссылке: https://vk.me/akulaopt_86
                                    И узнай, что мы можем тебе предложить!
                                </News>
                            )}
                        </div>
                    </div>
                </div>
            </main>
        )
    }
}