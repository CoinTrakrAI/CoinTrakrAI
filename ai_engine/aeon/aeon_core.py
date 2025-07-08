
def resolve_conflict(model_outputs):
    votes = {"BUY": 0, "SELL": 0, "HOLD": 0}
    for output in model_outputs:
        votes[output] += 1
    return max(votes, key=votes.get)
