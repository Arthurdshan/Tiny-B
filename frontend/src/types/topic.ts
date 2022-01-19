

export type Reply = {
    id: number;
    date: Date;
    body: string;
}

export type Topic = {
    id: number;
    date: Date;
    title: string;
    body: string;
    replies: Reply[];
}

export type TopicPage = {
    content: Topic[];
    last: boolean;
    totalPages: number;
    totalElements: number;
    size: number;
    number: number;
    first: boolean;
    numberOfElements: number;
    empty: boolean;
}