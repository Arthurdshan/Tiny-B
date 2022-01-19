import { FormEvent, useState } from "react";
import './index.css';
import { useNavigate } from "react-router-dom";
import { toast } from 'react-toastify';
import { Topic } from "../../types/topic";
import { API } from "../../utils/requests";

const NewTopic = () => {

    const [title, setTitle] = useState<string>("");
    const [body, setBody] = useState<string>("");

    const navigate = useNavigate();

    const handleTopicSubmit = async (sub: FormEvent<HTMLFormElement>, topic: string, comment: string) => {
        sub.preventDefault();
        try {
            const response = await API.post(`/topics`, {
                title: topic,
                body: body
            });
            const data = response.data as Topic;
            navigate(`/topic/${data.id}`);
        } catch (e) {
            console.log(e);
            toast.error("An error occurred while creating the topic.");
        }
    }

    return (
        <>
            <div className="d-flex flex-start h-100">
                <div className="w-100 m-auto p-3">
                    <form onSubmit={sub => handleTopicSubmit(sub, title, body)}>
                        <label className="fw-bold form-label">
                            Topic title
                        </label>
                        <input
                            required
                            className="outline form-control w-50 mb-3"
                            onChange={e => setTitle(e.target.value)}
                            minLength={1}
                            maxLength={100}
                        />
                        <label className="fw-bold form-label">
                            Comment
                        </label>
                        <textarea
                            required
                            style={{ resize: "none" }}
                            className="form-control"
                            onChange={e => setBody(e.target.value)}
                            minLength={1}
                            maxLength={10000}
                        />
                        <button className="btn btn-light mx-auto w-20 mt-2 py-0 border" type="submit">
                            Post
                        </button>
                    </form>
                </div>
            </div>
        </>
    );
};

export default NewTopic;