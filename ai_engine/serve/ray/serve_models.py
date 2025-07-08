
from ray import serve

@serve.deployment
class JarvisModel:
    def __init__(self, model):
        self.model = model

    async def __call__(self, starlette_request):
        input_data = await starlette_request.json()
        return self.model(input_data)
