from django.db import models

# Create your models here.
class Item(models.Model):
    item_name = models.CharField(max_length=45, unique=True)
    item_description = models.CharField(max_length=255, blank=True, null=True)
    item_price = models.DecimalField(max_digits=10, decimal_places=2)

    def __str__(self):
        return self.item_name
