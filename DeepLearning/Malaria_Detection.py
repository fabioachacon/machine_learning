import keras
from keras.callbacks import EarlyStopping, ReduceLROnPlateau
from keras_preprocessing.image import ImageDataGenerator
from keras.layers import Conv2D, MaxPooling2D, Dense, BatchNormalization, Dropout
from keras.models import Sequential
from keras.applications.vgg16 import VGG16
from dataVisu import plot_results


train_data = r'C:\Users\fabio\Documents\DataSets\cell_images\train_base\train_data'
validation_data = r'C:\Users\fabio\Documents\DataSets\cell_images\train_base\validation_data'

batch_size = 100


def pretrained_model(num_units, trainable=False):
    conv_base = VGG16(weights='imagenet',
                      include_top=False,
                      input_shape=(60, 60, 3))
    model = Sequential([conv_base,
                       keras.layers.Flatten(),
                       Dense(num_units, activation='relu'),
                       Dense(1, activation='sigmoid')])
    model.trainable = trainable
    return model


train_datagen = ImageDataGenerator(rescale=1./255,
                                   rotation_range=40,
                                   width_shift_range=0.2,
                                   horizontal_flip=True,
                                   shear_range=0.2,
                                   zoom_range=0.2,
                                   fill_mode='nearest')

train_generator = train_datagen.flow_from_directory(
    directory=train_data,
    target_size=(60, 60),
    class_mode='binary',
    batch_size=batch_size
)

validation_datagen = ImageDataGenerator(rescale=1./255)

validation_generator = validation_datagen.flow_from_directory(
    directory=validation_data,
    target_size=(60, 60),
    batch_size=50,
    class_mode='binary'
)

callback_list = [EarlyStopping(patience=5, monitor='acc'),
                 ReduceLROnPlateau(patience=5)]

model = keras.models.Sequential([Conv2D(12, (5, 5), activation='relu', input_shape=(60, 60, 3)),
                                 Conv2D(32, (3, 3), activation='relu'),
                                 Conv2D(64, (3, 3), activation='relu'),
                                 MaxPooling2D(2, 2),
                                 BatchNormalization(),
                                 Conv2D(128, (3, 3), activation='relu'),
                                 Conv2D(142, (3, 3), activation='relu'),
                                 Conv2D(152, (1, 1), activation='relu'),
                                 MaxPooling2D(2, 2),
                                 Conv2D(164, (3, 3), activation='relu'),
                                 Conv2D(182, (1, 1), activation='relu',),
                                 MaxPooling2D(2, 2),
                                 MaxPooling2D(1, 1),
                                 BatchNormalization(),
                                 keras.layers.Flatten(),
                                 Dense(150, activation='relu'),
                                 Dense(1, activation='sigmoid')])


model.compile(loss=keras.losses.binary_crossentropy,
              optimizer=keras.optimizers.Adam(lr=0.001),
              metrics=['acc'])

hist = model.fit_generator(train_generator,
                           steps_per_epoch=180,
                           epochs=15,
                           validation_steps=80,
                           validation_data=validation_generator,
                           callbacks=callback_list,
                           )

model.save(r'C:\Users\fabio\Documents\models\malaria_detection_model4.h6')


loss = hist.history['loss']
val_loss = hist.history['val_loss']

train_acc = hist.history['acc']
val_acc = hist.history['val_acc']

epochs = range(1, 1 + len(loss))

plot_results(epochs, train_loss=loss, train_acc=train_acc, val_loss=val_loss, val_acc=val_acc)