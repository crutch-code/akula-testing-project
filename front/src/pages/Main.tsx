import React, {Component} from 'react'
import {News} from '../components/News'
import {NewsType} from '../types/NewsType'

export default class Main extends Component<any, any> {
    state = {
        news: []
    }

    componentDidMount() {
        fetch("http://localhost:8080/api/news", {method: "GET"})
            .then((response) => response.json())
            .then((data: any) => {
                this.setState({
                    news: data.body.content
                });
            })
            .catch((error) => console.error(error));

    }

    render() {
        const {news} = this.state;
        return (
            <main>
                <div className={'section'}>
                    <div className="container">
                        <div className="row mb-5">
                            {news.map((news: NewsType) =>
                                <News key={news.id} newsId={news.id} title={news.title}
                                      image='https://media.cntraveller.com/photos/611bf0b8f6bd8f17556db5e4/master/pass/gettyimages-1146431497.jpg'
                                      authorId={news.author.id}
                                      authorName={news.author.fio}
                                      authorAvatar='https://www.vhv.rs/dpng/d/551-5511364_circle-profile-man-hd-png-download.png'
                                      date={new Date(Date.parse(news.publishDate)).toLocaleString("ru-RU", {
                                          day: '2-digit',
                                          month: 'long',
                                          year: 'numeric'
                                      })}>
                                    {news.content}
                                </News>
                            )}
                        </div>
                    </div>
                </div>
            </main>
        )
    }
}