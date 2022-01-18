import axios from "axios";
import moment from "moment";
import { FormEvent, useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { toast } from "react-toastify";
import { Topic } from "../../types/topic";
import { BASE_URL } from "../../utils/requests";
import './index.css';

const TopicPage = () => {
    const params = useParams();
    const userName = "Anonymous";

    const [reply, setReply] = useState<string>("");
    const [topic, setTopic] = useState<Topic>({
        id: 0,
        date: new Date(),
        title: "",
        body: "",
        replies: []
    });

    const handleTopicSubmit = async (sub: FormEvent<HTMLFormElement>, reply: string) => {
        try {
            await axios.post(`${BASE_URL}/replies`, {
                topicId: topic.id,
                body: reply
            });
        } catch (e) {
            console.log(e);
            toast.error("An error occured while trying to add a reply");
        }
    }

    useEffect(() => {
        (async () => {
            const response = await axios.get(`${BASE_URL}/topics/${params.id}`);
            const data = response.data as Topic;
            setTopic(data);
        })();
    }, [params.id]);

    return (
        <div className="m-3">
            <div className="border p-2 mb-2">
                <form onSubmit={sub => handleTopicSubmit(sub, reply)}>
                    <label className="fw-bold form-label">
                        Reply
                    </label>
                    <textarea
                        required
                        style={{ resize: "none" }}
                        className="form-control"
                        onChange={e => setReply(e.target.value)}
                        minLength={1}
                        maxLength={10000}
                    />
                    <button className="btn btn-light mx-auto w-20 mt-2 py-0 border" type="submit">
                        Post
                    </button>
                </form>
            </div>
            <div className="border mb-3 p-2">
                <div className="d-flex border border p-2 mb-3">
                    <span className="mb-0" style={{ fontWeight: "bold" }}>TOPIC: </span>
                    <span className="mb-0" style={{ fontWeight: "bold" }}>{topic.title}</span>
                </div>
                <div className="border p-2">
                    <div className="d-flex">
                        <span style={{ fontWeight: "bold", marginRight: "0.5em" }}>{userName}</span>
                        <span style={{ marginRight: "0.5em" }}>{moment(topic.date).fromNow()}</span>
                        <span>No.{topic.id}</span>
                    </div>
                    <p className="mb-0">{topic.body}</p>
                </div>
            </div>
            <div className="border px-2 pt-2">
                {
                    topic.replies.length === 0

                        ?

                        <div className="mb-2">
                            <span>No replies.</span>
                        </div>

                        :

                        topic.replies.map(reply => (
                            <div key={reply.id} className="d-flex border mb-2 text-decoration-none">
                                <div className="p-2">
                                    <div className="d-flex">
                                        <span style={{ fontWeight: "bold", marginRight: "0.5em" }}>{userName}</span>
                                        <span style={{ marginRight: "0.5em" }}>{moment(reply.date).fromNow()}</span>
                                        <span>No.{reply.id}</span>
                                    </div>
                                    <p className="mb-0">{reply.body}</p>
                                </div>
                            </div>
                        )
                        )
                }
            </div>
        </div>
    );
};

export default TopicPage;