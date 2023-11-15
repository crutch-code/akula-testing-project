import React, {Component} from 'react'

export class News extends Component<any, any> {
    contentPreviewLength: number = 100;

    constructor(props: any) {
        super(props);
        this.state = {
            id: props.newsId,
            image: props.image,
            date: props.date,
            author: {
                id: props.authorId,
                name: props.authorName.split(' ')[1].substring(0, 1) + '. ' + props.authorName.split(' ')[0],
                photo: props.authorAvatar
            },
            title: props.title,
            content: props.children
        };
    }

    render() {
        return (
            <div className="col-12 col-md-6 col-lg-6 mb-5">
                <div className="card bg-primary border-light shadow-soft">
                    <img src={this.state.image} className="card-img-top rounded-top" alt='image'/>
                    <div className="card-body pt-2">
                        <div className="media d-flex align-items-center justify-content-between">
                            <div className="post-group">
                                <a href={'/user/'+this.state.author.id}><img className="avatar-sm mr-2 img-fluid rounded-circle"
                                                 src={this.state.author.photo} alt={'Автор'}/>&nbsp;{this.state.author.name}</a>
                            </div>
                            <div className="d-flex align-items-center">
                                <span className="small"><span
                                    className="far fa-calendar-alt mr-2"></span>{this.state.date}</span>
                            </div>
                        </div>
                        <h3 className="h5 card-title mt-4">{this.state.title}</h3>
                        <p className="card-text">{this.state.content.substring(0, Math.min(this.state.content.length, this.contentPreviewLength))}...</p>
                        <a href={'/news/'+this.state.id} className="btn btn-primary btn-sm">Читать далее ...</a>
                    </div>
                </div>
            </div>
        );
    }
}
