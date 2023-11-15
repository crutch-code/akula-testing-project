import React, {Component} from 'react'
import {News} from '../components/News'
import {NewsType} from '../types/NewsType'
import {REST} from "../api/REST";

export default class Main extends Component<any, any> {
    state = {
        news: []
    }

    componentDidMount() {
        REST.getNews().then(n => {
            this.setState({news: n});
        });
    }

    render() {
        const {news} = this.state;
        return (
            <main>
                <div className={'section'}>
                    <div className="container">
                        <div className="row mb-5">
                            {news.map((n: NewsType) =>
                                <News key={n.id} newsId={n.id} title={n.title}
                                      image='https://media.cntraveller.com/photos/611bf0b8f6bd8f17556db5e4/master/pass/gettyimages-1146431497.jpg'
                                      authorId={n.author.id}
                                      authorName={n.author.fio}
                                      authorAvatar='https://www.vhv.rs/dpng/d/551-5511364_circle-profile-man-hd-png-download.png'
                                      date={new Date(Date.parse(n.publishDate)).toLocaleString("ru-RU", {
                                          day: '2-digit',
                                          month: 'long',
                                          year: 'numeric'
                                      })}>
                                    {n.content}
                                </News>
                            )}
                        </div>
                    </div>
                </div>
            </main>
        )
    }
}