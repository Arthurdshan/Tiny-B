import { useEffect, useState } from "react";
import { TopicPage } from "../../types/topic";
import axios from "axios";
import { BASE_URL } from "../../utils/requests";
import { Link } from "react-router-dom";
import './index.css'
import moment from "moment";

const Listing = () => {

    const [pageNumber, setPageNumber] = useState(0);
    const [topics, setTopics] = useState<TopicPage>({
        content: [],
        last: true,
        totalPages: 0,
        totalElements: 0,
        size: 20,
        number: 0,
        first: true,
        numberOfElements: 0,
        empty: true
    });

    useEffect(() => {
        (async () => {
            const response = await axios.get(`${BASE_URL}/topics?size=20&page=${pageNumber}`);
            const data = response.data as TopicPage;
            setTopics(data);
        })();
    }, [pageNumber]);

    return (
        <div className="mx-3">
            <h5 className="my-3">Latest posts</h5>
            <div>
                {
                    !topics.empty
                        ?
                        topics.content.sort((a, b) => { return b.id - a.id }).map(topic => (
                            <Link key={topic.id} to={`/topic/${topic.id}`} className="d-flex border mb-2 text-decoration-none colorchanger">
                                <div style={{ width: "100%" }} className="text-dark d-flex justify-content-between p-2">
                                    <span className="mb-0 fw-bold">
                                        {topic.title}
                                    </span>
                                    <span className="mb-0">
                                        {moment(topic.date).fromNow()}
                                    </span>
                                </div>
                            </Link>
                        ))
                        :
                        (
                            <h5>
                                No posts.
                            </h5>
                        )
                }
            </div>
        </div>
    );
}

export default Listing;