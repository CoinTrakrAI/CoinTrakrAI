
def generate_response(message, mode="beginner"):
    if mode == "beginner":
        return f"👍 Great news! {message} 🎉"
    elif mode == "intermediate":
        return f"{message} — looking good."
    return f"[AI Report] {message}"
