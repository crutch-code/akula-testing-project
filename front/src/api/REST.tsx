import {NewsType} from '../types/NewsType'

export class REST {

    protected static get(url: string): any {
        fetch(url, {method: "GET"})
            .then((response) => response.json())
            .then((data: any) => {
                return data;
            })
            .catch((error) => console.error(error));
    }

    public static getNews(): Promise<NewsType[]> {
        return fetch("/api/news", {method: "GET"})
            .then((response) => response.json())
            .then((data: any) => { return data.body.content; })
            .then((data: NewsType[]) => { return data; });
            //.catch((error) => console.warn(error));
    }
}