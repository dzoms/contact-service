CREATE TABLE IF NOT EXISTS user_contact_entity (
    id UUID primary key,
    user1_id UUID NOT NULL,
    user2_id UUID NOT NULL,
    UNIQUE(user1_id, user2_id)
)